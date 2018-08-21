<?php
// 20180821 Sun GuoLei - 解析 xmind 用例 php 版
// 加载 xmind content.xml 文件
$xml = simplexml_load_file("content2.xml");

// 获取第一个 topic 节点
$topic = $xml->sheet->topic;
// 声明 module 模块
$module = "";
// 调用解析函数
parseTopic($topic, $module);

// 递归函数，直到 topic 最内侧一层，打印 module 和 title
function parseTopic($topic, $module)
{
    // flag 用来标记到达最内层
    $flag = false;
    // 获取 topic 子节点中 title 的个数，children 的个数
    $tempCount = $topic->children()->count();
    // topic 下只有一个子节点
    if ($tempCount == 1) {
        $titleCount = 1;
        $childrenCount = 0;
//  topic 下有多个子节点，遍历计算 title 的个数，children 的个数
    } else {
        $titleCount = 0;
        $childrenCount = 0;
        foreach ($topic->children() as $child) {
            if (0 == strcmp($child->getName(), "title")) {
                $titleCount++;
            }
            if (0 == strcmp($child->getName(), "children")) {
                $childrenCount++;
            }
        }
    }
    // 遍历子节点
    // 子节点为最内侧 title 时，打印 title 和 module
    // 子节点不是最内侧，则拼接 module
    foreach ($topic->children() as $child) {

        // 到达最内侧 title，打印结果
        if (0 == strcmp($child->getName(), "title") && ($titleCount == 1) && ($childrenCount == 0)) {
            // 达到最内侧 title 节点时打印 module 和 title
            echo "--------begin<br />";
            echo $module . "<br />";
            echo $child . "<br />";
            echo "--------end<br />";
            break;
        }
        // 不是最内侧，拼接 module
        if (0 == strcmp($child->getName(), "title") && ($tempCount > 1)) {
            $module .= "/" . $child;
        }
        // 存在 children 节点，递归调用
        if (0 == strcmp($child->getName(), "children")) {
            // 遍历 children 节点下的 topics 节点下的所有 topic 节点
            foreach ($child->topics->children() as $topic1) {
                // 递归调用
                parseTopic($topic1, $module);
            }
        }
    }
}

?>