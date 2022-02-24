**Note that some errors may occur with response code `500`; those are errors we did not expect.**

# /user

## /user/register

### POST

With parameters `username`, `email`, and `password`.

**Successful response:**

With status code 200,

```json
{ "id": 31, "username": "karimpwnz", "email": "karim@1karimrahal.com" }
```

**Input Error:**

With a non-200 status code,

```json
{ "error": "Some error!" }
```

## /user/login

### POST

With parameters `username` and  `password`.

**Successful response:**

With status code 200,

```json
{ "id": 31, "username": "karimpwnz", "email": "karim@1karimrahal.com" }
```

**Login Error:**

With status code 401,

```json
{ "error": "Invalid username and password pair!" }
```

## /user/info

### GET

Get the current user's info.

**Successful response:**

With status code 200,

```json
{ "id": 31, "username": "karimpwnz", "email": "karim@1karimrahal.com" }
```

**Not logged in error:**

With status code 401,

```json
{ "error": "You are not logged in!" }
```

# /cart

## /cart/items

### GET

Get the current user's cart items.

**Successful response:**

With a 200 status code,

```json
[
    {
        "id": 1,
        "name": "Supreme Hoodie",
        "price": "69.99",
        "picture": "https://some_url",
        "brand": "Supreme",
        "source": "https://link-to-supreme-hoodie",
        "description": "An amazing hoodie",
        "colors": "(2,1,3);(1,2,3);(4,3,2)"
    }
]
```

**Error response**:

With a non-200 status code,

```json
{ "error": "Some error!" }
```

## /cart/items/<item_id>

### PUT

Add the item with the specified `<item_id>` to the current user's cart

**Successful response:**

Status code 200

**Error response**:

With a non-200 status code,

```json
{ "error": "Some error!" }
```

### DELETE

Remove the item with the specified `<item_id>` from the current user's cart

**Successful response:**

Status code 200

**Error response**:

With a non-200 status code,

```json
{ "error": "Some error!" }
```

## /cart/publish

### GET

**Successful response:**

(note that the first id [32] is the id of the outfit)

With status 200,

```json
{
    "id": 37,
    "owner": { "id": 32, "username": "karimpwnz" },
    "items": [
        {
            "id": 1,
            "name": "Supreme Hoodie",
            "price": "69.99",
            "picture": "https://some_url",
            "brand": "Supreme",
            "source": "https://link-to-supreme-hoodie",
            "description": "An amazing hoodie",
            "colors": "(2,1,3);(1,2,3);(4,3,2)"
        }
    ],
    "likes": 0
}
```

**Error response**:

With a non-200 status code,

```json
{ "error": "Some error!" }
```

# /outfits

## /outfits/popular

### GET

Get list of top 10 most popular outfits.

**Successful response:**

With status code 200 and in descending order of popularity,

```json
[
    {
        "id": 37,
        "owner": { "id": 32, "username": "karimpwnz" },
        "items": [
            {
                "id": 1,
                "name": "Supreme Hoodie",
                "price": "69.99",
                "picture": "https://some_url",
                "brand": "Supreme",
                "source": "https://link-to-supreme-hoodie",
                "description": "An amazing hoodie",
                "colors": "(2,1,3);(1,2,3);(4,3,2)"
            }
        ],
        "likes": 1
    },
    {
        "id": 36,
        "owner": { "id": 32, "username": "karimpwnz" },
        "items": [
            {
                "id": 1,
                "name": "Supreme Hoodie",
                "price": "69.99",
                "picture": "https://some_url",
                "brand": "Supreme",
                "source": "https://link-to-supreme-hoodie",
                "description": "An amazing hoodie",
                "colors": "(2,1,3);(1,2,3);(4,3,2)"
            }
        ],
        "likes": 0
    }
]
```

**Error response**:

With a non-200 status code,

```json
{ "error": "Some error!" }
```

## /outfits/<outfit_id>

### GET

**Successful response:**

(note that the first id [32] is the id of the outfit)

With status code 200,

```json
{
    "id": 37,
    "owner": { "id": 32, "username": "karimpwnz" },
    "items": [
        {
            "id": 1,
            "name": "Supreme Hoodie",
            "price": "69.99",
            "picture": "https://some_url",
            "brand": "Supreme",
            "source": "https://link-to-supreme-hoodie",
            "description": "An amazing hoodie",
            "colors": "(2,1,3);(1,2,3);(4,3,2)"
        }
    ],
    "likes": 0
}
```

**Error response**:

With a non-200 status code,

```json
{ "error": "Some error!" }
```

### DELETE

**Successful response:**

Status code 200

**Error response**:

With a non-200 status code,

```json
{ "error": "Some error!" }
```

## /outfits/<outfit_id>/liked

### GET

Check whether current user likes outfit.

**Successful response:**

```json
{ "liked": true }
```

**Error response**:

With a non-200 status code,

```json
{ "error": "Some error!" }
```

## /outfits/<outfit_id>/like

### GET

Like an outfit as current user.

**Successful response:**

Status code 200

**Error response**:

With a non-200 status code,

```json
{ "error": "Some error!" }
```

## /outfits/<outfit_id>/unlike

### GET

Unlike an outfit as current user.

**Successful response:**

Status code 200

**Error response**:

With a non-200 status code,

```json
{ "error": "Some error!" }
```
