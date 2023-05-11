#!/usr/bin/env bash

ABSPATH=$(readlink -f $0)
ABSDIR=$(dirname $ABSPATH)
source ${ABSDIR}/profile.sh

IDLE_PORT=$(find_idle_port)

echo "  >> Check Application PID running on $IDLE_PORT"
IDLE_PID=$(lsof -ti tcp:${IDLE_PORT})

if [ -z ${IDLE_PID} ]
then
  echo "    - NOT EXIST"
else
  echo "    - Application pid: $CURRENT_PID"
  echo "  >> kill -15 $CURRENT_PID"
  kill -15 ${IDLE_PID}
  sleep 5
fi