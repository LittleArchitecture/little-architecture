    /** 
     * 树状菜单，显示在主界面的左边 
     */  
    Ext.define('app.view.main.region.MainMenuTree', {  
                extend : 'Ext.tree.Panel',  
                alias : 'widget.mainmenutree',  
                title : '系统菜单',  
                glyph : 0xf0c9,  
                lines : true,  
                viewModel : 'main',  
                border:false,
                autoWidth:true,
                initComponent : function() {  
                    this.store = Ext.create('Ext.data.TreeStore', {  
                                root : {  
                                    text : '系统菜单',  
                                    leaf : false,  
                                    expanded : true , 
                                    children:[]
                                }  
                            });  
                    var menus = this.getViewModel().get('systemMenu');  
                    var root = this.store.getRootNode();  
                   
                    for (var i in menus) {  
                        var menugroup = menus[i];  
                        var menuitem = root.appendChild({  
                        	
                                    text : menugroup.text,  
                                    expanded : menugroup.expanded,  
                                    icon : menugroup.icon,  
                                    glyph : menugroup.glhpy  
                                });  
                        
                       /**
                        for (var j in menugroup.items) {  
                            var menumodule = menugroup.items[j];  
                            var childnode = {  
                                moduleId : menumodule.text,  
                                moduleName : menumodule.module,  
                                text : menumodule.text,  
                                leaf : true  
                            };  
                            menuitem.appendChild(childnode);  
                        }  
                        
                        **/
                    }  
                    this.callParent(arguments);  
                    
                }  
            }) ;