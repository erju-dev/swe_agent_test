#!/bin/bash

# This script is used to backup the database of the website
# Declare mysql credentials
MYSQL_USER="root"
MYSQL_PASSWORD="root"
MYSQL_HOST="localhost"
MYSQL_DATABASE="wordpress"

# Runs mysqldump to create a gzipped copy of the database.
# The filename is the current data and time.
mysqldump -u$MYSQL_USER -p$MYSQL_PASSWORD -h$MYSQL_HOST $MYSQL_DATABASE | gzip > "$MYSQL_DATABASE-$(date +%Y-%m-%d-%H-%M-%S).sql.gz"

# Rsync the dumpt to the backup server.
rsync -avz "$MYSQL_DATABASE-$(date +%Y-%m-%d-%H-%M-%S).sql.gz" user@server:/path/to/backup