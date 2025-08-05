<body bgcolor="lightyellow" text="red">

<%@page isELIgnored="false"%>
<!-- allows EL -->

<!-- Dot operator and [] both are valid in EL syntax -->

SupplierId:: ${param.supplierid1}
SupplierName:: ${param.suppliername1}

SupplierId:: ${param['supplierid1']}
SupplierName:: ${param['suppliername1']}

<!-- NO FOR LOOP -->
<!-- paramValues display only the checked checkboxes! -->
Location: ${paramValues.c1[0]}
${paramValues.c1[1]}
${paramValues.c1[2]}
