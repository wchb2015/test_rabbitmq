#!/bin/sh

# customize
TEAM="jarch"
APP_ID="me.ele.pylon.sample.spring"

MAIN_CLASS="me.ele.pylon.spring.util.Bootstrap"

SCRIPTS_DIR=`dirname "$0"`
PROJECT_DIR=`cd $SCRIPTS_DIR && pwd`
DT=`date +"%Y%m%d_%H%M%S"`

CLASS_PATH="$PROJECT_DIR/conf:$PROJECT_DIR/lib/*:$CLASS_PATH"

MEM_OPTS="-Xms2g -Xmx2g -Xmn768m"

START_OPTS="$START_OPTS -Djava.io.tmpdir=$PROJECT_DIR/tmp/"
START_OPTS="$START_OPTS -Duser.dir=$PROJECT_DIR"
START_OPTS="$START_OPTS -DTEAM=${TEAM} -DAPPID=${APP_ID}"
START_OPTS="$START_OPTS -Dfile.encoding=UTF-8"

#run java
mkdir -p "$PROJECT_DIR/tmp/"
mkdir -p "$PROJECT_DIR/logs/"
java -server $MEM_OPTS $START_OPTS -classpath $CLASS_PATH $MAIN_CLASS

# END OF FILE

