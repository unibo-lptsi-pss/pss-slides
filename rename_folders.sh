#!/bin/bash

# Script to rename folders in lecture-markdown/content
# Removes the "xy." prefix from folder names where xy is a number

CONTENT_DIR="lecture-markdown/content"

# Check if the content directory exists
if [ ! -d "$CONTENT_DIR" ]; then
    echo "Error: Directory $CONTENT_DIR does not exist"
    exit 1
fi

# Change to the content directory
cd "$CONTENT_DIR" || exit 1

# Find all directories matching the pattern xy.yz-* where xy and yz are numbers
# and rename them to remove the "xy." prefix
for dir in [0-9][0-9].[0-9]*; do
    # Check if the pattern matched any files
    if [ ! -e "$dir" ]; then
        continue
    fi
    
    # Extract the new name by removing everything before and including the first dot
    new_name="${dir#*.}"
    
    # Check if the new name would be different
    if [ "$dir" != "$new_name" ]; then
        echo "Renaming: $dir -> $new_name"
        
        # Check if target directory already exists
        if [ -e "$new_name" ]; then
            echo "  WARNING: Target directory '$new_name' already exists. Skipping."
        else
            mv "$dir" "$new_name"
            echo "  ✓ Done"
        fi
    fi
done

echo ""
echo "Renaming complete!"
