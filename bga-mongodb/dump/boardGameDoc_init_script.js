print('board game create script start');

db.boardGames.insert(
  { upsert: true }
);
db.blogPosts.insert(
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
