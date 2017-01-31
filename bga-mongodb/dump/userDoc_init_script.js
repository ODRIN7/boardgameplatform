print('user creates init script start');

db.boardgames.update(
  {"username": "user1"},
  {
    "username": "user1",
    "password": "pwd1"
  },
  { upsert: true }
);

print('user creates init script start');
