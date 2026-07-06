#!/bin/bash
set -e

MAIN_REPO="devsensei404/LeetCode-Jutsu"
MAIN_BRANCH="main"
YOUR_NAME="devsensei404"
YOUR_EMAIL="subhadeeppaul51@gmail.com"

WORKDIR=$(mktemp -d)
cd "$WORKDIR"

# Clone the main repo using the PAT
git clone "https://x-access-token:${MAIN_REPO_PAT}@github.com/${MAIN_REPO}.git" main-repo
cd main-repo
git checkout "$MAIN_BRANCH" || git checkout -b "$MAIN_BRANCH"

# Copy latest state of secondary repo's tracked files (excluding .git)
rsync -av --exclude='.git' --exclude='.github' "$GITHUB_WORKSPACE"/ ./

# Configure commit identity as YOU on main account
git config user.name "$YOUR_NAME"
git config user.email "$YOUR_EMAIL"

git add -A

# Get the latest commit message + original date from the secondary repo
cd "$GITHUB_WORKSPACE"
LAST_MSG=$(git log -1 --pretty=%s)
LAST_DATE=$(git log -1 --pretty=%aI)
cd "$WORKDIR/main-repo"

if ! git diff --cached --quiet; then
  GIT_AUTHOR_DATE="$LAST_DATE" GIT_COMMITTER_DATE="$LAST_DATE" \
    git commit -m "$LAST_MSG"
  git push origin "$MAIN_BRANCH"
else
  echo "No changes to commit."
fi
