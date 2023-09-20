#!/usr/bin/env ruby

def warning(file)
    "\n<!-- this file includes generated content. Do not edit. Edit #{file}, instead. -->\n"
end

files = Dir["**/content/**/*generator.md"]
puts "Files to examine: #{files}"
matcher = /<!--\s+write-here\s+"(?<path>[^"]+)"\s*-->(?<contents>.*?)<!--\s*end-write\s*-->/sum

for file in files do
    puts "Replacing contents of #{file}"
    text = File.read(file)
    loop do
        match = text.match(matcher)
        break if match.nil?
        source = match[:path]
        replacement = File.read(source)
        text.sub!(matcher, "#{warning(file)}\n#{File.read(source)}\n")
        puts "Replacement with the contents of #{source}"
    end
    target_dir = File.dirname(file)
    File.write("#{target_dir}/_index.md", text)
end
