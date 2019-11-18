#!/usr/bin/env bash


echo 'Copy files...'

scp -i ~/.ssh/id_rsa \
    target/ilil-0.0.1-SNAPSHOT.jar \
    77053@34.66.228.223:/home/77053/

echo 'Restart server...'

ssh -i ~/.ssh/id_rsa 77053@34.66.228.223 << EOF
pgrep java | xargs kill -9
nohup java -jar ilil-0.0.1-SNAPSHOT.jar > log.txt &
EOF

echo 'Bye'