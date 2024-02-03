# jetpack_compose_modifier

## Modifierとは
- ComposeUIライブラリです。
- UI要素の外観や動作を変更するために使用される修飾子です。
- Modifierに紐ずく様々な修飾子を組み合わせてUI要素を変更していきます。

## 主な修飾子
- サイズや配置
    - size：要素のサイズ指定（例：Modifier.size(100.dp, 100.dp）//縦横共に100dpに設定）
    - padding：要素の内部余白を指定（例：Modifier.pading(10.dp）//内部余白を10dpに設定）
    - align：要素の配置方法を指定（例：Modifier.align(Alignment.Center)//表示時に中央に表示されるように設定）

- 表示関連
    - alpha：要素の透明度を指定（例：Modifier.alpha(0.5f)//半透明に設定）
    - background：要素の背景を指定（例：Modifier.background(Color.Blue)//背景色を青に設定）

- ユーザーアクション検知
    - clickable：クリック可能な要素を指定（例：Modifier.clickable {クリック時の処理}//クリックした時の処理を設定）
    - onFocusChanged：フォーカスを変更時の要素を指定（例：Modifier.onFocusChanged {フォーカス変更時処理}//フォーカスが変更した時の処理を設定）

他にも様々な修飾子がありUIの要素によって使い分けが必要です。
参考ページは[こちら](https://developer.android.com/jetpack/compose/modifiers-list?hl=ja)

マージンは要素の「外側」に適用されますが、パディングは「内側」に適用されます。
現状、marginが存在しないのは修飾子の設計によって、
動作は明示的かつ予測可能なものとするためであり望みどおりの動作を実現するよう
詳細に管理できるようになります。

トルツメに関しては「View.GONE」などを設定したて対応していたと思いますが
Composeを使用したUI構築では「View.GONE」などは使用せずにおこわなれます。
ただし、非表示（表示していた領域を残して消える）することは可能です。
トルツメにの方法は後述に記載するのでそちらを参考にしてください。


## コード記述時の設定法など
- コード１
```kotlin=
fun showList(
) {
    LazyColumn {
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .padding(bottom = 1.dp)
                    .background(Color.Gray)
                    .clickable { Log.d("TAG","アイテム押下") }
            ) {
                Text(
                    text = "アイテム1",
                    fontSize = 18.sp
                )
            } 
        }
    }
}
```
上記のコードを例に説明します。
Modifierの部分を見てください。
設定に関しては下記の順で設定されます。
1. 高さを50dpに設定
2. 横幅を画面の横幅まで広げる
3. paddingを下に1dp設定
4. 背景色を灰色に設定
5. 押下時の処理を設定

個々にリストアイテムの制約を設定した場合のスクショ

<img src="https://github.com/hiroki-kawada/jetpack_compose_modifier/assets/61892987/ce746732-a970-4224-9080-6fa1b9da4098" width="320px">


- コード2
```kotlin=

fun showScreen(modifier: Modifier = Modifier
        .height(50.dp)
        .fillMaxWidth()
        .padding(bottom = 1.dp)
        .background(Color.Gray)
        .clickable { Log.d("TAG","アイテム押下") }) {
    
    fun showList(modifier)

}


fun showList(
    modifier: Modifier = Modifier
) {
    LazyColumn {
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = modifier
            ) {
                Text(
                    text = "アイテム1",
                    fontSize = 18.sp
                )
            } 
        }
    }
}
```
上記のコードは一つ目に紹介したコードと設定は変わっていませんが
Modifierに修飾子を追加している箇所が異なります。
１つ目のコードはアイテムを生成時にModifierを生成し修飾子を設定してます。
ですが2つ目のコードは処理を呼び出す前に設定して対応しています。
これを行うことにより複数のアイテムを同じレイアウトで設定することが可能になります。
(※LazyColumnのitem関数を使用する場合)


全てのリストアイテムに同じ制約を設定した場合のスクショ


<img src="https://github.com/hiroki-kawada/jetpack_compose_modifier/assets/61892987/94732ab4-755d-49ff-9e8f-f3418e94eba8" width="320px">


- 基本的に処理呼び出し元でレイアウトの共通の設定をModifierで設定して対応し個々でレイアウトを変更したい時はレイアウト設定時にModifierに追加で修飾子を設定するようにしましょう。

- コード3

```kotlin=
Box(
        contentAlignment = Alignment.Center
    ) {
        // Padding
        Text(
            text = "Modifier Example",
            modifier = Modifier
                .padding(10.dp)
                .background(Color.Red)
                .padding(10.dp)
                .background(Color.Green)
        )
}

```
上記のコードに関してはバックグラウンドの色が最後に緑色を指定しているので
緑色になるのかなと個人的には思いましたが実際に端末で確認すると
このように宣言の順番通りに宣言した処理が実行されるため順番にも気をつけましょう。
- 処理順
1. paddingを10dpに設定
2. 背景色を赤色に設定
3. paddingを10dpに設定（※このときに背景赤色の部分が10dp拡がる）
4. 背景色を緑色に設定


- アイテム１は「paddingとBackGround」の指定をそれぞれ前後したときの表示
- アイテム2は「paddingとborder」の指定をそれぞれ前後したときの表示
- アイテム3は「paddingとclickable」の指定をそれぞれ前後したときの表示(動画を貼り付けたのでそちらで確認可能)

<img src="https://github.com/hiroki-kawada/jetpack_compose_modifier/assets/61892987/0adcd275-db65-4212-9e9c-bfc6db00acbd" width="320px">

https://github.com/hiroki-kawada/jetpack_compose_modifier/assets/61892987/51481991-02df-4022-a5cb-6b6eea175999

## レイアウトなどをトルツメする方法
- UI構築をする際にボタン押下などで状態を変更しViewの表示非表示を変更すると思うのですがModifierを使用してこのようなViewの表示状態を変更することはありません。
- ComposeUIの要素を変更するものであり表示非表示を行うのはまた別です。
- 表示、非表示など状態を更新するときは「remember」関数を使用します。
- 「remember」関数はComposable関数なのでUIコンポーネントのComposableと同様のライフサイクルや再コンポジションが適用されます。
- 「remember」関数を使用することによりUIの状態変更を実施します。


```kotlin=

fun Sample1(
    modifier: Modifier = Modifier
) {
    val editable = remember { mutableStateOf(true) }
    Column(
        modifier
            .fillMaxWidth()
            .background(Color.Gray)
    ) {
        if (editable.value) {
            Text("Text")
        }
        Button(
            onClick = { editable.value = !editable.value },
            modifier = modifier.fillMaxWidth()
        ) {
            Text(text = "表示切り替えボタン")
        }
    }
}
```

https://github.com/hiroki-kawada/jetpack_compose_modifier/assets/61892987/ac5f993d-95ed-4105-b872-b3256140f851


## まとめ
- ModifierとはComposeUIライブラリでありUI要素の外観や動作を設定するのに用いる。
- 表示、非表示はModifierで設定できるがトルツメといったUIの表示エリアごと消すといったことはModifierでは出来ない。
- 宣言の順番通りに外観や動作が設定されるので注意が必要。
