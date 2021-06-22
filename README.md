
전체 유저 조회 Query
```shell script
query {
    userList {
      id
      name
      email
      posts{
        id
        title
      }
      comments{
        title
      }
    }
}
```

전체 유저 조회 응답
```shell script
{
  "data": {
    "userList": [
      {
        "id": 1,
        "name": "name1",
        "email": "email1@naver.com",
        "posts": [
          {
            "id": 1,
            "title": "포스트1"
          },
          {
            "id": 2,
            "title": "포스트2"
          },
          {
            "id": 3,
            "title": "포스트3"
          }
        ],
        "comments": [
          {
            "title": "제목1"
          },
          {
            "title": "제목2"
          },
          {
            "title": "제목3"
          },
          {
            "title": "제목4"
          }
        ]
      },
      {
        "id": 2,
        "name": "name2",
        "email": "email2@naver.com",
        "posts": [
          {
            "id": 4,
            "title": "포스트4"
          }
        ],
        "comments": [
          {
            "title": "제목5"
          }
        ]
      },
      {
        "id": 3,
        "name": "name3",
        "email": "email3@naver.com",
        "posts": [
          {
            "id": 5,
            "title": "포스트5"
          }
        ],
        "comments": [
          {
            "title": "제목6"
          },
          {
            "title": "제목7"
          }
        ]
      }
    ]
  }
}

```