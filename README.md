# AcappellaFella

## Problem Domain
Our problem domain is focused on making a trivia game. At a high level we were planning on creating a multiplayer game where one person is selected to sing a song in front of the other players and said players would have to guess what song the singer is singing. The person selected as the singer will have the option to pick one of the three randomized songs which will be retrieved from the Spotify API. 

## API Documentation
[Spotify API](https://developer.spotify.com/documentation/web-api)
[Lyrics API](https://lyricsovh.docs.apiary.io/#reference/0/lyrics-of-a-song/search)

## Hoppscotch Example
The following examples use Hoppscotch to test the Spotify API. Since the access token test requires both parameter and header data, which can't be shown in one screenshot, the following links are provided instead.

[Requesting access token](https://hopp.sh/r/iEQUzq89H6rC)

[Requesting track data](https://hopp.sh/r/9KAk1NiLXi1Z)

## Java Example
### Input
```
String accessToken = SpotifyDemo.requestAccessToken();

JSONObject artistData = SpotifyDemo.requestArtistData(accessToken, "3ICflSq6ZgYAIrm2CTkfVP");
System.out.println(artistData.toString(4));
```

### Output
```
{
    "images": [
        {
            "width": 640,
            "url": "https://i.scdn.co/image/ab6761610000e5eb3ce1e2a99cffc7c662938b01",
            "height": 640
        },
        {
            "width": 320,
            "url": "https://i.scdn.co/image/ab676161000051743ce1e2a99cffc7c662938b01",
            "height": 320
        },
        {
            "width": 160,
            "url": "https://i.scdn.co/image/ab6761610000f1783ce1e2a99cffc7c662938b01",
            "height": 160
        }
    ],
    "followers": {
        "total": 2288674,
        "href": null
    },
    "genres": [
        "album rock",
        "british invasion",
        "classic rock",
        "hard rock",
        "protopunk",
        "psychedelic rock",
        "rock"
    ],
    "popularity": 64,
    "name": "The Animals",
    "href": "https://api.spotify.com/v1/artists/3ICflSq6ZgYAIrm2CTkfVP",
    "id": "3ICflSq6ZgYAIrm2CTkfVP",
    "type": "artist",
    "external_urls": {"spotify": "https://open.spotify.com/artist/3ICflSq6ZgYAIrm2CTkfVP"},
    "uri": "spotify:artist:3ICflSq6ZgYAIrm2CTkfVP"
}
```

## Technical Issues
While we have no issues with the Spotify API, we have not come to a solution on how we are going to stream the audio. Our approach are as follows:
- To record the singer’s audio, we are planning on using the MediaStream Recording API.
- If this does not work, our alternative is to use the Discord API to make this game in the form of a Discord bot. 
