print('user creates init script start');

db.users.insert(
  {
    "username": "username0",
    "password": "password0"
  },
  {upsert: true}
);
db.sequence.insert(
  {
  _id: "user",
    seq: 0
  },
  {upsert: true}
);
print('user creates init script end');
