package com.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * liyang 2021-03-09
 * （改遍自IRule实现类RandomRule）
 *
 * 每个服务，访问5次~，换下一个服务（3个）
 * total=0, 默认=0，如果=5，我们指向下一个服务节点
 * index=0，默认0，如果total=5，index+1
 */
public class LYRandomRule extends AbstractLoadBalancerRule {

    private int total = 0;        // 被调用的次数
    private int currentIndex = 0; // 当前是谁在提供服务~

    //@edu.umd.cs.findbugs.annotations.SuppressWarnings(value = "RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE")
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {

            if (Thread.interrupted()) {
                return null;
            }

            List<Server> upList = lb.getReachableServers(); //获得活着的服务
            List<Server> allList = lb.getAllServers();      //获得全部的服务（包括ping不通的）

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

//            int index = chooseRandomInt(serverCount); // 生成区间随机数
//            server = upList.get(index);               // 从活着的服务中，随机获取一个


            /*****************************主要加的逻辑********************************/

            if (total < 5) {
                server = upList.get(currentIndex);
                total++;
            } else {
                total = 0;
                currentIndex++;
                if (currentIndex >= upList.size()) {  // 调头
                    currentIndex = 0;
                }
                server = upList.get(currentIndex);    // 从活着的服务中，获取指定的服务来进行操作
            }

            /*****************************主要加的逻辑********************************/

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }
}
