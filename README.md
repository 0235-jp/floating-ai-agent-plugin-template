# TemplateContentProvider 📱

[日本語版](https://github.com/0235-jp/floating-ai-agent-plugin-template/blob/main/README_JP.md)

## Overview
`TemplateContentProvider` is the starting point for developing [Floating AI agent](https://play.google.com/store/apps/details?id=jp.co.u0235.floating_ai_agent) plugins! 🚀 This template provides the basic framework for the plugin and demonstrates how to return results for specific function queries.

## Floating AI Agent Plugin Overview 🪄
- Provides detailed information about Tools that Floating AI Agent can use! 🔍
- Returns results for Tools executions from Floating AI Agent! 💫

## Specifications 📑
### Android Manifest Settings
- Floating AI Agent recognizes providers set with the [jp.co.u0235.floating_ai_agent.ACTION_TOOLS](https://github.com/0235-jp/floating-ai-agent-plugin-template/blob/360d5850f4e695c4953f4dc7f264501dbf289be9/app/src/main/AndroidManifest.xml#L24) action as plugins! 🧐
- Floating AI Agent accesses plugins using the [jp.co.u0235.floating_ai_agent.permission.TOOLS_READ](https://github.com/0235-jp/floating-ai-agent-plugin-template/blob/360d5850f4e695c4953f4dc7f264501dbf289be9/app/src/main/AndroidManifest.xml#L22) permission! 🔑

### ContentProvider Implementation 🛠️
- Floating AI Agent accesses plugins using the `query()` method! ✨
- For queries to the [tools](https://github.com/0235-jp/floating-ai-agent-plugin-template/blob/360d5850f4e695c4953f4dc7f264501dbf289be9/app/src/main/java/jp/co/u0235/floating_ai_agent_plugin/template/TemplateContentProvider.kt#L35C1-L35C1) endpoint, set and return the list and details of the functions provided by the plugin in a cursor. 📜
  - The [parameters](https://github.com/0235-jp/floating-ai-agent-plugin-template/blob/360d5850f4e695c4953f4dc7f264501dbf289be9/app/src/main/java/jp/co/u0235/floating_ai_agent_plugin/template/TemplateContentProvider.kt#L36-L42) are as follows:
    - `displayName`: The name of the tool displayed in the app 🏷️
    - `functionName`: The function name recognized by AI 🤖
    - `description`: The description of the function recognized by AI 📖
    - `parametersSchema`: A string representing the JSON object of parameters recognized by AI (the JSON object of parameters in the [OpenAI API](https://platform.openai.com/docs/api-reference/chat/create)) 📊
- Floating AI Agent accesses the function by setting the [functionName](https://github.com/0235-jp/floating-ai-agent-plugin-template/blob/360d5850f4e695c4953f4dc7f264501dbf289be9/app/src/main/java/jp/co/u0235/floating_ai_agent_plugin/template/TemplateContentProvider.kt#L47) specified in the tools endpoint and sets the parameters specified in `parametersSchema` in the [pathSegments](https://github.com/0235-jp/floating-ai-agent-plugin-template/blob/360d5850f4e695c4953f4dc7f264501dbf289be9/app/src/main/java/jp/co/u0235/floating_ai_agent_plugin/template/TemplateContentProvider.kt#L49C44-L49C44). The processed result is set in the [result](https://github.com/0235-jp/floating-ai-agent-plugin-template/blob/360d5850f4e695c4953f4dc7f264501dbf289be9/app/src/main/java/jp/co/u0235/floating_ai_agent_plugin/template/TemplateContentProvider.kt#L48) column of the cursor and returned. Floating AI Agent only uses the first item in the cursor! 📈

Developers, let's use this template to add unique functionalities and expand our horizons! 💡🎉
