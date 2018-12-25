package cn.navigation.education.changliao;

import cn.navigation.education.changliao.handler.ServerHandler;
import cn.navigation.education.changliao.pages.Login;
import cn.navigation.education.changliao.verticle.LoginVerticle;
import cn.navigation.education.changliao.verticle.MainPageVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import javafx.application.Platform;


import static cn.navigation.education.changliao.config.Constant.VERTICLE_CONFIG;

public class MainVerticle {

    public static final Vertx vertx = Vertx.vertx();


    public MainVerticle() {
        //启动javafx线程
        Platform.startup(()->new Login());
        //部署Vertice
        deploymentVertical();
    }

    public void deploymentVertical() {
        var options = new DeploymentOptions().setConfig(VERTICLE_CONFIG);
        vertx.deployVerticle(new ServerHandler(), options);
        vertx.deployVerticle(new LoginVerticle());
        vertx.deployVerticle(new MainPageVerticle());
    }

    static public void main(String... args) { new MainVerticle(); }
}
