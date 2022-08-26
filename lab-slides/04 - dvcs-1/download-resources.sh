#!/bin/sh

set -e

download_image() {
    DESTINATION="img/${1##*/}"
    echo $1
    echo $DESTINATION
    if [ ! -f "$DESTINATION" ]; then
        curl -o "$DESTINATION" "$1"
    fi
}

download_image "https://git-scm.com/book/en/v2/images/deltas.png"
download_image "https://git-scm.com/book/en/v2/images/snapshots.png"
download_image "https://git-scm.com/book/en/v2/images/areas.png"
