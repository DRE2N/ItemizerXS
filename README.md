# ItemizerXS
[![Build Status](https://app.travis-ci.com/DRE2N/ItemizerXS.svg?branch=master)](https://app.travis-ci.com/DRE2N/ItemizerXS)
[![codebeat badge](https://codebeat.co/badges/b6e3a916-329e-44cf-a46d-3a000ab9824b)](https://codebeat.co/projects/github-com-dre2n-itemizerdre-master) <br>
A simple plugin to customize items & signs ingame via commands.

## Features
- Edit an ItemMeta with a single command
- Add/change/remove sign lines
- Supports 1.16+ colors
- Uses and parses [adventure Components](https://github.com/KyoriPowered/adventure)

## Compatibility

### Server
ItemizerXS works with Paper 1.18 and higher. This plugin only works with Paper and does not support Spigot or CraftBukkit builds.

### Bedrock
[Bedrock](https://github.com/DRE2N/Bedrock) is a utility library for common tasks.

## Commands
`/ii` - Lists every plugin command <br>
`/ii attr` - Lists every attribute command <br>
`/ii attr add <attribute> <strength> <operation> [slot]` - Adds the given attribute modifier <br>
`/ii attr remove <attribute|slot>` - Removes the given attribute or every attribute at the given slot <br>
`/ii book` - Lists every book command <br>
`/ii book author <name>` - Sets the author of the book <br>
`/ii book generation <generation>` - Sets the book generation <br>
`/ii book title <title>` - Sets the title of the book <br>
`/ii book writable` - Gives you a writable version of the book <br>
`/ii durability <durability>` - Sets the item durability <br>
`/ii enchant` - Lists every enchantment command <br>
`/ii enchant add <enchantment> <level>` - Adds the enchantment with the given level <br>
`/ii enchant remove <enchantment>` - Removes the given enchantment <br>
`/ii flag` - Lists every flag command <br>
`/ii flag add <flag>` - Adds the given item flag <br>
`/ii flag remove <flag>` - Removes the given item flag <br>
`/ii help` - Lists every plugin command <br>
`/ii lore` - Lists every lore command <br>
`/ii lore add <line>` - Adds the given line to the lore <br>
`/ii lore change <index> <line>` - Changes the given index line <br>
`/ii lore clear` - Deletes the item lore <br>
`/ii lore get` - Copies the given lore line <br>
`/ii lore insert <index> <line>` - Adds the line before the given index <br>
`/ii lore remove <index>` - Removes the lore line at the given index <br>
`/ii name <name>` - Sets the item name <br>
`/ii reset` - Resets the item meta <br>
`/ii data` - Sets the custom model data <br>
`/ii sign` - Lists every sign command <br>
`/ii sign clear` - Deletes all sign lines <br>
`/ii sign set <index> <line>` - Sets the sign line at the given index <br>
`/ii type <type>` - Sets the item material <br>
 
