package src.cn.sunguolei.study.Java.RecursionTest;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author GuoLei Sun
 * Date: 2018/11/27 10:06 AM
 * <p>
 * 功能：递归画树形列表
 *
 * 系统包含模块，模块包含子模块
 * 系统表
 * 模块表
 */
//public class RecursionTest {
//
//    // 页面左侧的系统、模块层级列表的缓存，存放在 redis 中
//    private static Nodes[] nodesCache = null;
//    // springboot 中会自动注入 redisTemplate
//    private RedisTemplate redisTemplate = new RedisTemplate();
//
//    // 获取 index 页面左侧的系统、模块层级列表
//    private Nodes[] getNodesData(List<ApiSystem> systemList, List<ApiModule> moduleList) {
//        // 保存系统的数量和模块的数量到 redis 中，防止每次请求都嵌套循环，提高性能
//        String systemCounter = (String) redisTemplate.opsForValue().get("api:index:system:counter");
//        String moduleCounter = (String) redisTemplate.opsForValue().get("api:index:module:counter");
//        int systemActual = systemList.size();
//        int moduleActual = moduleList.size();
//        boolean isChanged = false;
//
//        if (nodesCache != null && systemCounter != null && moduleCounter != null) {
//            // 如果缓存中数量和实际数量有任一个不相等，就更新缓存的数值
//            if ((systemActual != Integer.parseInt(systemCounter)) ||
//                    (Integer.parseInt(moduleCounter) != moduleActual)) {
//                isChanged = true;
//            }
//        } else {
//            isChanged = true;
//        }
//
//        // 如果缓存获取到的值和数据库查询的值不一致，说明系统和module 被更新了
//        // 防止数量没变化，只有名字更新了，所以 redis 中的键要设置失效时间，1小时
//        if (isChanged) {
//            // 创建对应系统数量的数组
//            Nodes[] nodes = new Nodes[systemList.size()];
//            for (int i = 0; i < nodes.length; i++) {
//                nodes[i] = new Nodes();
//                // 设置系统这一层的外观展示
//                // 系统名
//                nodes[i].setText(systemList.get(i).getName());
//                // 系统链接
////                nodes[i].setHref("javascript:getApiIndexData(0)");
//                nodes[i].setSelectable(false);
//                // 系统层级的颜色
//                nodes[i].setColor("green");
//
//                // 系统下模块列表
//                ApiModule apiModule = new ApiModule();
//                apiModule.setSystemId(systemList.get(i).getId());
//
//                // 通过 service 层查找对应的模块列表
////                List<ApiModule> apiModuleList = moduleService.findRelatedModule(apiModule);
//                // 根据具体的业务调用合适的查库方法，类似上方，此处只是避免 IDE 报错
//                List<ApiModule> apiModuleList = new ArrayList<>();
//                apiModuleList.add(apiModule);
//                // 递归遍历所有的模块层级，组成模块树结构，返回给前端渲染展示
//                if (apiModuleList != null && apiModuleList.size() > 0) {
//                    getTree(nodes[i], apiModuleList);
//                }
//            }
//
//            // 设置节点缓存
//            nodesCache = nodes;
//            // 设置 redis 缓存
//            redisTemplate.opsForValue().set("api:index:system:counter",
//                    String.valueOf(systemActual), 1, TimeUnit.HOURS);
//            redisTemplate.opsForValue().set("api:index:module:counter",
//                    String.valueOf(moduleActual), 1, TimeUnit.HOURS);
//            // 前端获取 data 变量展示模块层级
//            return nodes;
//        } else {
//            return nodesCache;
//        }
//    }
//
//    /**
//     * 获取一个模块下的所有子模块层级，赋值给 Nodes 数组
//     *
//     * @param node          拼成的节点
//     * @param apiModuleList 要获取的下一级模块 列表
//     */
//    private void getTree(Nodes node, List<ApiModule> apiModuleList) {
//
//        // 初始化 Nodes 数组
//        node.setNodes(new Nodes[apiModuleList.size()]);
//
//        for (int i = 0; i < node.getNodes().length; i++) {
//
//            // 数组中的每个 Nodes 都必须先初始化，对象数组需要先初始化才能使用，不然为 null
//            node.getNodes()[i] = new Nodes();
//            Nodes nodeTemp = node.getNodes()[i];
//
//            int systemId = apiModuleList.get(i).getSystemId();
//            int moduleId = apiModuleList.get(i).getId();
//            String moduleName = apiModuleList.get(i).getName();
//
//            nodeTemp.setText(moduleName);
//            nodeTemp.setHref("javascript:getApiIndexData('systemId=" + systemId + "&moduleId=" + moduleId + "')");
//            nodeTemp.setSelectable(true);
//
//            // 要查询的子模块的查询条件
//            ApiModule newApiModule = new ApiModule();
//            newApiModule.setSystemId(systemId);
//            newApiModule.setParentId(moduleId);
//            // 查找该模块下一级子模块
////            List<ApiModule> moduleList = moduleService.findRelatedModule(newApiModule);
//            // 根据具体的业务调用合适的查库方法，类似上方，此处只是避免 IDE 报错
//            List<ApiModule> moduleList = new ArrayList<>();
//            apiModuleList.add(new ApiModule());
//            // 递归结束条件，如果查到的子模块列表为空的话，结束当前这一次方法调用
//            if (moduleList != null && moduleList.size() > 0) {
//                getTree(nodeTemp, moduleList);
//            }
//        }
//    }
//}
