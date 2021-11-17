package edu.isu.cs.cs2263.hw02;

import javafx.scene.Node;

public interface IAppView {

    Node getView();

    void initView();

    void updateData();
}
