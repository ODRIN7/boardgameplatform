#!/bin/bash
if test -z "odrin7"; then
    echo "odrin7 not defined"
    exit 1
fi

auth="-u admin -p odrin7"

# MONGODB USER CREATION
(
echo "setup mongodb auth"
create_user="if (!db.getUser('admin')) { db.createUser({ user: 'admin', pwd: 'odrin7', roles: [ {role:'userAdminAnyDatabase', db:'BoardGameArena'} ]}) }"
until mongo admin --eval "$create_user" || mongo admin ${auth} --eval "$create_user"; do sleep 5; done
killall mongod
sleep 1
killall -9 mongod
) &

# INIT DUMP EXECUTION
(
if test -n "$INIT_DUMP"; then
    echo "execute dump file"
	until mongo admin ${auth} $INIT_DUMP; do sleep 5; done
fi
) &

echo "start mongodb without auth"
chown -R mongodb /data/db
gosu mongodb mongod "$@"

echo "restarting with auth on"
sleep 5
exec gosu mongodb mongod --auth "$@"
