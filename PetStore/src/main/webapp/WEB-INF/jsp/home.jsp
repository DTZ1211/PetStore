<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script>

<html>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<head>
    <title>PetStore</title>
</head>
<body>

<form>
    <table class="table">
        <thead class="thead-light">
        <tr>
            <th scope="col">id</th>
            <th scope="col">类别id</th>
            <th scope="col">宠物名字</th>
            <th scope="col">标签id</th>
            <th scope="col">状态</th>
            <th scope="col">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pets}" var="p">
            <tr>
                <th scope="row">${p.id}</th>
                <td>${p.categoryId}</td>
                <td>${p.name}</td>
                <td>${p.tags}</td>
                <td>${p.status}</td>
                <td>
                    <a id="del" href="/del/${p.id}">删除</a>
                    <button type="button" class="btn btn-link" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">新增</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>

<form action="" method="post" id="delfrom">
    <input type="hidden" name="_method" value="DELETE" />
</form>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">新增宠物</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="/add" method="post" id="subform">
                    类别id:<select name="categoryId">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                            </select>
                    <br/><br/>
                    宠物名字:<input type="text" placeholder="宠物名字" name="name" />
                    <br/><br/>
                    图片:<input type="file" name="photourl" />
                    <br/><br/>
                    标签id:<select name="tags">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                                <option value="13">13</option>
                                <option value="14">14</option>
                                <option value="15">15</option>
                                <option value="16">16</option>
                            </select>
                    <br/><br/>
                    状态:<select name="status">
                                <option value="available">available</option>
                                <option value="pending">pending</option>
                                <option value="sold">sold</option>
                            </select>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="sub">提交</button>
            </div>
        </div>
    </div>
</div>

<script>
    $(function(){
        $('#del').click(function(){
            $('#delfrom').attr('action',this.href).submit();
            return false;
        })
    })

    $(function(){
        $("#sub").click(function(){
            $("#subform").submit();
        })
    })
</script>
</body>
</html>


