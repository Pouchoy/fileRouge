angular.module('fupApp', [])
        .constant("imageUrl", "http://localhost:8080/galeriePhoto/photo/liste")
        .controller('fupController', function ($scope, $http, imageUrl) {

            var formdata = new FormData();


            $scope.getTheFiles = function ($files) {
                angular.forEach($files, function (value, key) {

                    formdata.append(key, value);
                });
            };

            // NOW UPLOAD THE FILES.
            $scope.uploadFiles = function () 
            {
                var request = 
                {
                    method: 'POST',
                    url: 'http://localhost:8080/galeriePhoto/upload',
                    data: formdata,
                    headers: {
                        'Content-Type': undefined
                    }
                };

                // SEND THE FILES.
                $http(request)
                    .success(function (d) {
                        alert(d);
                    })
                    .error(function () {
                });
            }

             $scope.data = {"images" : []};

            $http.get(imageUrl)
             .then(function (response) {
                 $scope.data.images = response.data;
                 $scope.data.columns = [];
                 for (col in $scope.data.images[0]){
                    if (col != "id")
                        $scope.data.columns.push(col);
                 }
             }, function(response) {
                 $scope.data.error = response.status;
             });


            $scope.selectOrderColumn = function(col) 
            {
                $scope.data.filterColumn = col;
            }

            $scope.getOrderColumnClass = function(col) 
            {
                if (col == $scope.data.filterColumn)
                    return orderColumnClass;
                else
                    return "";
            }
            

        });