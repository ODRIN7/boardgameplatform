print('board game create script start');

db.boardgames.insert(
  {
    "_id": "1001",
    "id": 100,
    "shortDescription": "demo boardgame1"
  },
  { upsert: true }
);
db.blogPosts.insert(
  {
    _id: "blogPosts",
    title: "title",
    content: "content"
  },
  {upsert: true}
);
db.sequence.insert(
  {
    _id: "blogPost",
    seq: 1
  },
  {upsert: true}
);
print('board game create script end');
