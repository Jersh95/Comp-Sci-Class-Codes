import praw

app_id = "a2vJ--w9paRKrw"
app_secret = "OD2R_DC9xc_MVAY-moEQSKDQ_aM"
app_uri = "https://127.0.0.1:65010/authorize_callback"
app_scopes = "account creddits edit flair history identity livemanage modconfig modcontributors modflair modlog modothers modposts modself modwiki mysubreddits privatemessages read report save submit subscribe vote wikiedit wikiread"
app_ua = "Automatic replier (Created by /u/_Sonny_v. 0.1)"
app_account_code = ""
app_refresh = ""


def login():
    r = praw.Reddit(app_ua)
    r.set_oauth_app_info(app_id, app_secret, app_uri)
    r.refresh_access_information(app_refresh)
    return r
