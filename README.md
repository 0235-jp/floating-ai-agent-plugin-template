# TemplateContentProvider 📱

[日本語版](https://github.com/0235-jp/floating-ai-agent-plugin-template/blob/main/README_JP.md)

## Overview
`TemplateContentProvider` is the starting point for developing plugins for the [Floating AI Agent](https://play.google.com/store/apps/details?id=jp.co.u0235.floating_ai_agent). 🚀 This template provides the basic framework for the plugin and demonstrates how to respond to queries for specific functionalities.

## Details of Floating AI Agent Plugin 🪄
- Provides detailed information about the Tools available in Floating AI Agent! 🔍
- Returns the results of executing Tools to Floating AI Agent! 💫

## Plugin Configuration 🛠️
### Android Manifest Settings
- Floating AI Agent recognizes providers set with [jp.co.u0235.floating_ai_agent.ACTION_TOOLS](https://github.com/0235-jp/floating-ai-agent-plugin-template/blob/26f726f485d66c9cf3197d3881016d98a7408bb4/app/src/main/AndroidManifest.xml#L23C26-L23C26) as plugins. 🧐
- Accesses the plugin using the [jp.co.u0235.floating_ai_agent.permission.TOOLS_READ](https://github.com/0235-jp/floating-ai-agent-plugin-template/blob/26f726f485d66c9cf3197d3881016d98a7408bb4/app/src/main/AndroidManifest.xml#L21C39-L21C39) permission. 🔑

### [Plugin Implementation](https://github.com/0235-jp/floating-ai-agent-plugin-template/blob/26f726f485d66c9cf3197d3881016d98a7408bb4/app/src/main/java/jp/co/u0235/floating_ai_agent_plugin/template/TemplateContentProvider.kt#L51)
- Floating AI Agent accesses the plugin through the `query()` method. ✨
- Performs a query to the `tools` endpoint, setting and returning the plugin's feature list and details in a cursor. 📜
  - Parameters:
    - `source`: Data source (provider or activity).
    - `target`: Access target (URI for providers, ClassName for activities).
    - `displayName`: Tool name displayed in the app 🏷️.
    - `functionName`: Function name recognized by AI 🤖.
    - `description`: Function description recognized by AI 📖.
    - `displayDescription`: Function description displayed in the app 📖.
    - `parametersSchema`: JSON string representing parameters recognized by AI.

### [Processing when source is a provider](https://github.com/0235-jp/floating-ai-agent-plugin-template/blob/26f726f485d66c9cf3197d3881016d98a7408bb4/app/src/main/java/jp/co/u0235/floating_ai_agent_plugin/template/TemplateContentProvider.kt#L69C22-L69C22)
- Floating AI Agent executes a query to the URI set in `target` with parameters specified in `parametersSchema` set as pathSegments.
- The process results are set and returned in the `type` and `result` columns of the cursor.
  - `type`: Either talk, text, image, or none.
    - `talk`: Floating AI Agent reads aloud the text set in `result`.
    - `text`: Floating AI Agent processes and reads aloud the string set in `result`.
    - `image`: Floating AI Agent processes and reads aloud the image object set in `result`.
      - Accepts images either base64-encoded or as a URL.
    - `none`: Floating AI Agent does nothing and transitions to a standby state.

### [Processing when source is an activity](https://github.com/0235-jp/floating-ai-agent-plugin-template/blob/26f726f485d66c9cf3197d3881016d98a7408bb4/app/src/main/java/jp/co/u0235/floating_ai_agent_plugin/template/SharVisionActivity.kt#L17)
- Floating AI Agent accesses the Activity set in `target` with parameters specified in `parametersSchema` set as extra.
- Please end the ActivityResult with {Key: uri, Value: URI of the provider} set as Extra.
- Afterward, Floating AI Agent executes a query to the Provider without parameters. The cursor settings are the same as when the source is a provider.