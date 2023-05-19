# LeroLero - WebMVC Service Architecture v1

Note: All of the following service specifications are suggestions at best, and may be modified as seen fit.

## API Gateway

### Get random noun list

Generates a list of random nouns.
The size of the list is determined by the positive integer query paramater `{size}`.
If not specified, `{size}` defaults to 1.
The return value is a JSON Array of strings.

**Endpoint**:

```ts
GET /nouns?size={size}
```

**Returns**:
200 OK

```ts
[ string ]
```

### Subscribe for random noun events

Gets a hyperreference pointing to a server-sent event noun source.
A time interval may be predefined with the non-negative integer query paramater `{interval}`, for milliseconds.
If not specified, `{interval}` defaults to 200ms.
The return value is a JSON Object, but the SSE noun source will be a text stream of "message" events.

**Endpoint**:

```ts
GET /nouns/events?interval={interval}
```

**Returns**:
200 OK

```ts
{
  href: string,
  method: string,
  type: string
}
```

### Get random verb list

Analogous to ["Get random noun list"](#get-random-noun-list) route.

**Endpoint**:

```ts
GET /verbs?size={size}
```

**Returns**:
200 OK

```ts
[ string ]
```

### Subscribe for random verb events

Analogous to ["Subscribe for random noun events"](#subscribe-for-random-noun-events) route.

**Endpoint**:

```ts
GET /verbs/events?interval={interval}
```

**Returns**:
200 OK

```ts
{
  href: string,
  method: string,
  type: string
}
```

### Get random adverb list

Analogous to ["Get random noun list"](#get-random-noun-list) route.

**Endpoint**:

```ts
GET /adverbs?size={size}
```

**Returns**:
200 OK

```ts
[ string ]
```

### Subscribe for random adverb events

Analogous to ["Subscribe for random noun events"](#subscribe-for-random-noun-events) route.

**Endpoint**:

```ts
GET /adverbs/events?interval={interval}
```

**Returns**:
200 OK

```ts
{
  href: string,
  method: string,
  type: string
}
```
