import praw
import random

APP_ID = "a2vJ--w9paRKrw"
APP_SECRET = "OD2R_DC9xc_MVAY-moEQSKDQ_aM"
APP_URI = "https://127.0.0.1:65010/authorize_callback"
APP_SCOPES = "account creddits edit flair history identity livemanage modconfig modcontributors modflair modlog modothers modposts modself modwiki mysubreddits privatemessages read report save submit subscribe vote wikiedit wikiread"
APP_UA = "Automatic replier (Created by /u/_Sonny_v. 0.1)"
APP_ACCOUNT_CODE = ""
APP_REFRESH = ""

WOOSH = "Woosh."
OTHER_RESPONSES = ["^ Username checks out.", "Are you serious?", "Oh boy, here we go",
                   "I need to save this for later references", "I don't even know anymore"]
CACHE = []
SUBREDDIT = "test"
MAX_POSTS = 100
CHOSEN_COMMENT = ""
WAIT = 20
CLEAN_CYCLE = 10
DO_SUBMISSIONS = False
DO_COMMENTS = True

print("Logging in...")
r = praw.Reddit(APP_UA)
r.set_oauth_app_info(APP_ID, APP_SECRET, APP_URI)
r.refresh_access_information(APP_REFRESH)

def replybot():
    print('Searching %s.' % SUBREDDIT)
    subreddit = r.get_subreddit(SUBREDDIT)
    posts = []
    if DO_SUBMISSIONS:
        posts += list(subreddit.get_new(limit=MAX_POSTS))
    if DO_COMMENTS:
        posts += list(subreddit.get_comments(limit=MAX_POSTS))
    #posts.sort(key=lambda x: x.created_utc)

    for post in posts:
        # Anything that needs to happen every loop goes here.
        pid = post.id

        try:
            pauthor = post.author.name

        except AttributeError:
            # Author is deleted. We don't care about this post.
            continue

        if pauthor.lower() == r.user.name.lower():
            # Don't reply to yourself
            print('Will not reply to myself.')
            continue

        if isinstance(post, praw.objects.Comment):
            pbody = post.body
        else:
            pbody = '%s %s' % (post.title, post.selftext)









