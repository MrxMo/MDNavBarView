# MDNavBarView
下拉导航菜单（仿美团导航下拉菜单）


使用方法：
1、添加navbarview包下的代码与对应资源
2、布局文件中添加：
<com.mr_mo.mdnavbarview.navbarview.MDNavBarView
        android:id="@+id/mdNavBarView"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <ListView
            android:id="@+id/listView"
            android:layout_width="match_parent"
            android:layout_height="match_parent"/>

    </com.mr_mo.mdnavbarview.navbarview.MDNavBarView>
    
3、添加导航item：
INavBarItemView itemViewAdress = new MDNavBarItemTitleView(this);
        itemViewAdress.setTitle("地区");
//        itemViewAdress.setTitleColorSelect(Color.RED);

        INavBarItemView itemViewTime = new MDNavBarItemTitleView(this);
        itemViewTime.setTitle("时间段");
//        itemViewTime.setTitleColorSelect(Color.RED);

        INavBarItemView itemViewFilter = new MDNavBarItemTitleView(this);
        itemViewFilter.setTitle("筛选");
//        itemViewFilter.setTitleColorSelect(Color.RED);

        List list = new ArrayList();
        list.add(itemViewAdress);
        list.add(itemViewTime);
        list.add(itemViewFilter);

        mdNavBarView.setNavBarItemView(list);
        mdNavBarView.setNavBarViewBGColor(Color.WHITE);
        
4、添加导航对应的item操作页面
 MDNavBarPopupSortView sortView1 = new MDNavBarPopupSortView(this);
        sortView1.setBackgroundColor(Color.YELLOW);
        sortView1.setNavBarPopupViewHeight(210);//设置下拉菜单的高度
        sortView1.setOnNavBarPopupSelectListener(new NavBarPopupSelectListener() {
            @Override
            public void onSelect(View view, int index, Object itemData) {
                mdNavBarView.hide();
                mdNavBarView.isShowNavBarItemIcon(false, index);
                NavBarSortModel model = (NavBarSortModel) itemData;
                mdNavBarView.setNavBarItemTitle(model.getTitle(), index);//更新导航标题
            }
        });

        List listOperateView = new ArrayList();
        listOperateView.add(sortView);
        listOperateView.add(sortView1);
        listOperateView.add(sortView2);
        mdNavBarView.setNavBarPopupOperateView(listOperateView);
        
