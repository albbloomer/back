package com.company.external.fetcher.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GitHubApiListResponse {

    @JsonProperty("current_user_url")
    private String currentUserUrl;

    @JsonProperty("current_user_authorizations_html_url")
    private String currentUserAuthorizationsHtmlUrl;

    @JsonProperty("authorizations_url")
    private String authorizationsUrl;

    @JsonProperty("code_search_url")
    private String codeSearchUrl;

    @JsonProperty("commit_search_url")
    private String commitSearchUrl;

    @JsonProperty("emails_url")
    private String emailsUrl;

    @JsonProperty("emojis_url")
    private String emojisUrl;

    @JsonProperty("events_url")
    private String eventsUrl;

    @JsonProperty("feeds_url")
    private String feedsUrl;

    @JsonProperty("followers_url")
    private String followersUrl;

    @JsonProperty("following_url")
    private String followingUrl;

    @JsonProperty("gists_url")
    private String gistsUrl;

    @JsonProperty("hub_url")
    private String hubUrl;

    @JsonProperty("issue_search_url")
    private String issueSearchUrl;

    @JsonProperty("issues_url")
    private String issuesUrl;

    @JsonProperty("keys_url")
    private String keysUrl;

    @JsonProperty("label_search_url")
    private String labelSearchUrl;

    @JsonProperty("notifications_url")
    private String notificationsUrl;

    @JsonProperty("organization_url")
    private String organizationUrl;

    @JsonProperty("organization_repositories_url")
    private String organizationRepositoriesUrl;

    @JsonProperty("organization_teams_url")
    private String organizationTeamsUrl;

    @JsonProperty("public_gists_url")
    private String publicGistsUrl;

    @JsonProperty("rate_limit_url")
    private String rateLimitUrl;

    @JsonProperty("repository_url")
    private String repositoryUrl;

    @JsonProperty("repository_search_url")
    private String repositorySearchUrl;

    @JsonProperty("current_user_repositories_url")
    private String currentUserRepositoriesUrl;

    @JsonProperty("starred_url")
    private String starredUrl;

    @JsonProperty("starred_gists_url")
    private String starredGistsUrl;

    @JsonProperty("topic_search_url")
    private String topicSearchUrl;

    @JsonProperty("user_url")
    private String userUrl;

    @JsonProperty("user_organizations_url")
    private String userOrganizationsUrl;

    @JsonProperty("user_repositories_url")
    private String userRepositoriesUrl;

    @JsonProperty("user_search_url")
    private String userSearchUrl;
}