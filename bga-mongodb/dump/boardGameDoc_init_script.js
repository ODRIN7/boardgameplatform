print('board game create script start');

db.boardgames.insert(
  {
    "_id": "1001",
    "id": 100,
    "shortDescription": "demo boardgame1"
  },
  { upsert: true }
);

print('board game create script end');
