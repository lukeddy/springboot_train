<#-- @ftlvariable name="t" type="com.yocool.todo.model.Todo" -->
<#-- @ftlvariable name="todos" type="java.util.Collection" -->
<#import '_main.ftl' as m>
<@m.page title="Todo List">
<div class="container text-center">
    <div class="row">
        <h1>任务列表</h1>
        <form action="todos" method="POST">
            <input type="text" name="description" placeholder="输入待完成任务">
            <button type="submit" class="btn btn-default">创建</button>
        </form>
    </div>
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th class="text-center">任务</th>
                <th class="text-center">创建时间</th>
                <th class="text-center">是否完成</th>
                <th class="text-center">操作</th>
            </tr>
            </thead>
            <tbody>
                <#list todos as t>
                <tr>
                    <td>${t.description?html}</td>
                    <td>${t.dateCreated}</td>
                    <td>${t.completed?string("是", "否")}</td>
                    <td>
                        <#if !t.completed>
                            <a href="todos/${t.id?c}/completed">标记完成</a>
                        </#if>
                        <a href="todos/${t.id?c}/delete">删除</a>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
        <#if !todos?has_content>
            <p>没有任务</p>
        </#if>
    </div>
    <div class="row">
        <a href="todos.csv">导出</a>
    </div>
</div>
</@m.page>