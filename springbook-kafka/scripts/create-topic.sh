#!/usr/bin/env bash

# Read command line arguments
if [[ $# < 1 ]]; then
    echo "Usage: $0 <topic>"
    exit -1
else
    topic=$1
fi

curl -X POST \
     -H "Accept: application/json" \
     -H "Content-Type: application/json" \
     -d '{"topic":"'$topic'"}' \
     http://localhost:8100/rest/api/v1/topics

echo
