<#import "parts/common.ftl" as c>

<@c.page>
    ${message?ifExists}
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input type="text" class="form-control" name="name" placeholder="Введите имя котика">
            </div>
            <div class="form-group">
                <div class="custom-file">
                    <input type="file" name="file" class="custom-file-input" id="customFile">
                    <label class="custom-file-label" for="customFile">Choose image</label>
                </div>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary ">Добавить своего котика</button>
            </div>
        </form>
    </div>
</@c.page>