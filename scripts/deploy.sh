#!/bin/bash

REPOSITORY=/home/ec2-user/app/step2
PROJECT_NAME=ian-springboot-webservice

echo "  >> Build file copy"

cp $REPOSITORY/zip/*.jar $REPOSITORY/

echo "  >> Current Running Application Check"

CURRENT_PID=$(pgrep -fl $PROJECT_NAME | grep jar | awk '{print $1}')

if [ -z "$CURRENT_PID" ]; then
    echo "    - NOT EXIST"
else
    echo "    - Application pid: $CURRENT_PID"
    echo "  >> kill -15 $CURRENT_PID"
    kill -15 $CURRENT_PID
    sleep 5
fi

echo "  >> New Application Deploy"

JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)

echo "  >> JAR Name: $JAR_NAME"

echo "  >> Add Execute Permission to $JAR_NAME"

chmod +x $JAR_NAME

ehco "  >> $JAR_NAME Execute"

nohup java -jar \
    -Dspring.config.location=classpath:/application.properties,classpath:/application-real.properties,/home/ec2-user/app/application-oauth.properties,/home/ec2-user/app/application-real-db.properties \
    -Dspring.profiles.active=real \
    $JAR_NAME > $REPOSITORY/nohup.out 2>&1 &