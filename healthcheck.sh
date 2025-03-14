#!/usr/bin/env bash
# Environment Variables
# HUB_HOST
# BROWSER
# MODULE

echo "Checking if hub is ready - $HUB_HOST"
echo "HUB_HOST is set to: $HUB_HOST"

while [ "$(curl -s http://$HUB_HOST:4444/wd/hub/status | jq -r .value.ready)" != "true" ]
do
    sleep 1
done

echo "Hub is ready!"

# Start the java command
java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DHUB_HOST=$HUB_HOST -Dbrowser=$browser org.tstng.TestNG testng.xml