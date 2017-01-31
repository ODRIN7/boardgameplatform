print('board game create script start');

db.boardgames.updateMany(
  {"id": 1001},
  {
    "_id": 11001,
    "id": 1001,
    "shortDescription": "demo boardgame1"
  },
  { upsert: true }
);

print('board game create script end');
