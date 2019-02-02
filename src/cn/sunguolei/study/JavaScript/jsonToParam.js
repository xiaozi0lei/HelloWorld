

// 将 json 转换为 paramList
function jsonToParam(jsonString, tbodyId) {
    // 将 json 字符串专为 json 对象
    var jsonObject = JSON.parse(jsonString);

    // 存放最终的参数数组
    var paramArray = [];
    // 参数的层级
    var grade = 0;
    // 遍历第一层对象
    for (var obj in jsonObject) {
        if (jsonObject.hasOwnProperty(obj)) {
            logObject(jsonObject[obj], grade, obj, "Object");
        }
    }

    // fieldType
    // 1 int
    // 2 String
    // 3 Object
    // 4 Array
    // ------ 此处为递归算法实现，遍历 json ------
    function logObject(val, grade, name, parentType) {

        var paramObject = new ParamObject();
        paramObject.fieldGrade = grade;
        paramObject.fieldName = name;

        if (val instanceof Array) {
            paramObject.fieldType = "4";
            paramArray.push(paramObject);

            for (var i = 0, n = val.length; i < n; i++) {
                if (i in val) {
                    logObject(val[i], grade + 1, i, "Array");
                }
            }
        } else if (typeof val === "object") {
            paramObject.fieldType = "3";
            var gradeTemp = grade +1;
            // 如果父类型为 Array，当前类型为 Object 的不加入到数组中
            if (parentType !== "Array") {
                paramArray.push(paramObject);
            } else {
                gradeTemp = grade;
            }

            for (var m in val) {
                if (val.hasOwnProperty(m)) {
                    logObject(val[m], gradeTemp, m, "Object");
                }
            }
        } else if (typeof val === "string") {
            paramObject.fieldType = "2";
            paramObject.fieldValue = val;
            paramArray.push(paramObject);
        } else if (typeof val === "number") {
            paramObject.fieldType = "1";
            paramObject.fieldValue = val;
            paramArray.push(paramObject);
        }
    }

    console.log(paramArray);

// 定义一个对象，存放 json 的各个属性，包括
// 字段类型：数组，对象，字符串，整型
// 字段key：
// 字段层级：grade
    function ParamObject(fieldGrade, fieldValue, fieldType, fieldDescription, fieldRequired, fieldName) {
        this.fieldGrade = fieldGrade;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.fieldType = fieldType;
        this.fieldDescription = fieldDescription;
        this.fieldRequired = fieldRequired;
    }

    // ------ 此处为表格拼接 ------
    var tBody = document.getElementById(tbodyId);
    for (var i = 0, len = paramArray.length; i < len; i++) {
        inParamCounter++;
        var paramObject = paramArray[i];

        var tr = document.createElement("tr");
        var fieldNameTd = document.createElement("td");
        var fieldTypeTd = document.createElement("td");
        var fieldValueTd = document.createElement("td");
        var fieldDescriptionTd = document.createElement("td");
        var fieldRequiredTd = document.createElement("td");
        var fieldOperateTd = document.createElement("td");
        var fieldGradeTd = document.createElement("td");

        // 设置 tr 的 style
        tr.classList.add("trStyle" + paramObject.fieldGrade);

        // fieldName
        var fieldName = document.createElement("input");
        fieldName.value = paramObject.fieldName;
        fieldName.classList.add("form-control");
        fieldName.type = "text";
        fieldName.name = "fieldName";
        fieldName.title = "字段名";
        fieldName.placeholder = "输入字段名";
        fieldName.style.display = "inline";
        fieldName.style.width = "auto";

        // 缩进插入点
        var indentSpan = document.createElement("span");
        var arrowString = "";
        for (var k = 0; k < paramObject.fieldGrade; k++) {
            arrowString += ">";
        }
        var indentText = document.createTextNode(arrowString);
        indentSpan.appendChild(indentText);
        fieldNameTd.appendChild(indentSpan);
        fieldNameTd.appendChild(fieldName);
        tr.appendChild(fieldNameTd);
        // fieldName

        // fieldType
        var fieldTypeSelect = document.createElement("select");
        fieldTypeSelect.classList.add("form-control");
        fieldTypeSelect.name = "fieldType";
        fieldTypeSelect.title = "请选择参数类型";
        fieldTypeSelect.value = paramObject.fieldType;

        // 字段类型 map
        var optionMap = [
            {"value": "1", "type": "int"},
            {"value": "2", "type": "String"},
            {"value": "3", "type": "Object"},
            {"value": "4", "type": "Array"}
        ];

        for (var j = 0, lenj = optionMap.length; j < lenj; j++) {
            var fieldTypeOption = document.createElement("option");
            fieldTypeOption.value = optionMap[j].value;
            fieldTypeOption.innerText = optionMap[j].type;
            if (optionMap[j].value === paramObject.fieldType) {
                fieldTypeOption.selected = true;
            }
            fieldTypeSelect.appendChild(fieldTypeOption);
        }

        fieldTypeTd.appendChild(fieldTypeSelect);
        tr.appendChild(fieldTypeTd);
        // fieldType

        // fieldValue
        var fieldValue = document.createElement("input");
        var value = paramObject.fieldValue;
        if (value !== "" && value !== null && value !== undefined) {
            fieldValue.value = value;
        } else {
            fieldValue.value = "";
        }
        fieldValue.classList.add("form-control");
        fieldValue.type = "text";
        fieldValue.name = "fieldValue";
        fieldValue.title = "字段值";
        fieldValue.placeholder = "输入字段值";
        fieldValueTd.appendChild(fieldValue);
        tr.appendChild(fieldValueTd);
        // fieldValue

        // fieldDescription
        var fieldDescription = document.createElement("input");
        var desValue = paramObject.fieldDescription;
        if (desValue !== "" && desValue !== null && desValue !== undefined) {
            fieldDescription.value = desValue;
        } else {
            fieldDescription.value = "";
        }
        fieldDescription.classList.add("form-control");
        fieldDescription.type = "text";
        fieldDescription.name = "fieldDescription";
        fieldDescription.title = "字段描述";
        fieldDescription.placeholder = "输入字段描述";
        fieldDescriptionTd.appendChild(fieldDescription);
        tr.appendChild(fieldDescriptionTd);
        // fieldDescription

        // fieldRequired
        var fieldRequiredLabel = document.createElement("label");
        var fieldRequired = document.createElement("input");
        fieldRequired.value = "1";
        fieldRequired.type = "checkbox";
        fieldRequired.name = "fieldRequired";
        fieldRequired.onchange = function () {
            changeValue(this);
        };

        fieldRequiredLabel.appendChild(fieldRequired);
        fieldRequiredTd.appendChild(fieldRequiredLabel);
        var myText = document.createTextNode(" 必填参数");
        fieldRequiredTd.appendChild(myText);
        tr.appendChild(fieldRequiredTd);
        // fieldRequired

        // fieldOperate
        var buttonAdd = document.createElement("button");
        buttonAdd.type = "button";
        buttonAdd.onclick = addInParamAdd;
        buttonAdd.innerText = "增加";

        var buttonDel = document.createElement("button");
        buttonDel.type = "button";
        buttonDel.onclick = function () {
            delInParamAdd(this);
        };
        buttonDel.innerText = "删除";

        fieldOperateTd.appendChild(buttonAdd);
        fieldOperateTd.appendChild(buttonDel);

        tr.appendChild(fieldOperateTd);
        // fieldOperate

        // fieldGrade
        var fieldGrade = document.createElement("input");
        fieldGrade.value = paramObject.fieldGrade;
        fieldGrade.classList.add("form-control");
        fieldGrade.type = "text";
        fieldGrade.name = "fieldGrade";
        fieldGrade.title = "字段层级";
        // fieldGrade.hidden = true;
        fieldGradeTd.appendChild(fieldGrade);
        fieldGradeTd.hidden = true;
        tr.appendChild(fieldGradeTd);

        // fieldGrade

        tBody.appendChild(tr);
    }
}