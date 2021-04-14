<#import "parts/common.ftl" as c>

<@c.page>
    <form action="test" method="post">
        <div class="form-group">
            <button type="submit" class="btn btn-primary ">Начать тест</button>
        </div>
    </form>
    <footer class="footer">
        <div class="container">
            <span class="text-muted"><a href="/addCat"  >Добавить своего котика</a></span>
        </div>
        <div class="container">
            <span class="text-muted"><a href="/winners"  >Список лидеров</a></span>
        </div>
    </footer>
</@c.page>