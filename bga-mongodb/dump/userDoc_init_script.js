print('user creates init script start');

db.users.insert(
  {
    "id": 100000,
    "username": "user1",
    "password": "pwd1"
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
