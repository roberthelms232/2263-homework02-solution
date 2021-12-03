package edu.isu.cs.cs2263.hw02;

import javafx.scene.Node;
import lombok.Getter;

public interface IAppView {
    Node getView();

    void initView();

    void updateData();
}
