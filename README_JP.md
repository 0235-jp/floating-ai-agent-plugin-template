# TemplateContentProvider 📱

## 概要
`TemplateContentProvider`は、[Floating AI agent](https://play.google.com/store/apps/details?id=jp.co.u0235.floating_ai_agent) プラグイン開発のスタート地点です！🚀 このテンプレートは、プラグインの基本的な枠組みを提供し、特定の機能に対するクエリに応じた結果を返す方法を示します。

## Floating AI Agentプラグインの概要 🪄
- Floating AI Agentが利用できるToolsの詳細情報を提供します！🔍
- Floating AI AgentからのTools実行に対して、結果を返します！💫

## 仕様 📑
### Androidマニフェスト設定
- Floating AI Agentは[jp.co.u0235.floating_ai_agent.ACTION_TOOLS](https://github.com/0235-jp/floating-ai-agent-plugin-template/blob/360d5850f4e695c4953f4dc7f264501dbf289be9/app/src/main/AndroidManifest.xml#L24)が設定されたproviderをプラグインとして認識します！🧐
- Floating AI Agentは[jp.co.u0235.floating_ai_agent.permission.TOOLS_READ](https://github.com/0235-jp/floating-ai-agent-plugin-template/blob/360d5850f4e695c4953f4dc7f264501dbf289be9/app/src/main/AndroidManifest.xml#L22)パーミッションを利用してプラグインにアクセスします！🔑

### ContentProviderの実装 🛠️
- Floating AI Agentは`query()`メソッドを使ってプラグインにアクセスします！✨
- [tools](https://github.com/0235-jp/floating-ai-agent-plugin-template/blob/360d5850f4e695c4953f4dc7f264501dbf289be9/app/src/main/java/jp/co/u0235/floating_ai_agent_plugin/template/TemplateContentProvider.kt#L35C1-L35C1)エンドポイントに対するクエリで、プラグインが提供する機能の一覧と詳細をcursorにセットして返してください。📜
  - [パラメータ](https://github.com/0235-jp/floating-ai-agent-plugin-template/blob/360d5850f4e695c4953f4dc7f264501dbf289be9/app/src/main/java/jp/co/u0235/floating_ai_agent_plugin/template/TemplateContentProvider.kt#L36-L42)はこんな感じ：
    - `displayName`: アプリ上に表示されるツールの名前 🏷️
    - `functionName`: AIが認識する機能の名前 🤖
    - `description`: AIが認識するその機能の説明 📖
    - `parametersSchema`: AIが認識するパラメータのJSONオブジェクトを表す文字列（[OpenAI API](https://platform.openai.com/docs/api-reference/chat/create)のtoolsのparametersのJSONオブジェクトです）📊
- Floating AI Agentはtoolsエンドポイントで設定した[functionName](https://github.com/0235-jp/floating-ai-agent-plugin-template/blob/360d5850f4e695c4953f4dc7f264501dbf289be9/app/src/main/java/jp/co/u0235/floating_ai_agent_plugin/template/TemplateContentProvider.kt#L47)をエンドポイントにして機能にアクセスし、`parametersSchema`で指定したパラメータを[pathSegments](https://github.com/0235-jp/floating-ai-agent-plugin-template/blob/360d5850f4e695c4953f4dc7f264501dbf289be9/app/src/main/java/jp/co/u0235/floating_ai_agent_plugin/template/TemplateContentProvider.kt#L49C44-L49C44)に設定します。処理した結果は[result](https://github.com/0235-jp/floating-ai-agent-plugin-template/blob/360d5850f4e695c4953f4dc7f264501dbf289be9/app/src/main/java/jp/co/u0235/floating_ai_agent_plugin/template/TemplateContentProvider.kt#L48)というカラムをcursorにセットして返してください。Floating AI Agentはcursorの1件目だけを利用します！📈

開発者のみなさん、このテンプレートを使って、ユニークな機能をどんどん追加していきましょう！💡🎉
