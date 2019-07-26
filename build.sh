#!/usr/bin/env bash

dos2unix docker/java/start.sh
cd Exam/
mvn clean;
mvn package;
cd ..
cp Exam/target/JavaTest5.jar  docker/java/app.jar
