<!DOCTYPE html>
<html ng-app="gemStore">
  <head>
    <link rel="stylesheet"  	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
    <script type="text/javascript"  	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.26/angular.js"></script>
    <script type="text/javascript" src="${context_path}/js/sample.js"></script>
  </head>


 <body ng-controller="StoreController as store">
    <header>
      <h1 class="text-center">Flatlander Crafted Gems</h1>
      <h2 class="text-center">� an Angular store �</h2>
    </header>
    <div class="list-group">
      <div class="list-group-item" ng-repeat="product in store.products">
        <h3>{{product.name}} <em class="pull-right">{{product.price | currency}}</em></h3>
        <div ng-controller="GalleryController as gallery"  ng-show="product.images.length">
          <div class="img-wrap">
            <img ng-src="{{product.images[gallery.current]}}" />
          </div>
          <ul class="img-thumbnails clearfix">
            <li class="small-image pull-left thumbnail" ng-repeat="image in product.images">
              <img ng-src="{{image}}" />
            </li>
          </ul>
        </div>
        <section ng-controller="TabController as tab">
          <ul class="nav nav-pills">
            <li ng-class="{ active:tab.isSet(1) }">
              <a href="" ng-click="tab.setTab(1)">Description</a>
            </li>
            <li ng-class="{ active:tab.isSet(2) }">
              <a href="" ng-click="tab.setTab(2)">Specs</a>
            </li>
            <li ng-class="{ active:tab.isSet(3) }">
              <a href="" ng-click="tab.setTab(3)">Reviews</a>
            </li>
          </ul>
          <div ng-show="tab.isSet(1)">
            <h4>Description</h4>
            <blockquote>{{product.description}}</blockquote>
          </div>
          <div ng-show="tab.isSet(2)">
            <h4>Specs</h4>
            <blockquote>Shine: {{product.shine}}</blockquote>
          </div>
          <div ng-show="tab.isSet(3)">
            <ul>
              <h4>Reviews</h4>
              <li ng-repeat="review in product.reviews">
                <blockquote>
                  <strong>{{review.stars}} Stars</strong>
                  {{review.body}}
                  <cite class="clearfix">�{{review.author}}</cite>
                </blockquote>
              </li>
            </ul>

            <!--  Review Form -->
            <form name="reviewForm">
              <!--  Live Preview -->
              <blockquote>
                <strong> Stars</strong>

                <cite class="clearfix">�</cite>
              </blockquote>

              <!--  Review Form -->
              <h4>Submit a Review</h4>
              <fieldset class="form-group">
                <select class="form-control" ng-options="stars for stars in [5,4,3,2,1]"  title="Stars">
                  <option value="">Rate the Product</option>
                </select>
              </fieldset>
              <fieldset class="form-group">
                <textarea class="form-control" placeholder="Write a short review of the product..." title="Review"></textarea>
              </fieldset>
              <fieldset class="form-group">
                <input type="email" class="form-control" placeholder="jimmyDean@example.org" title="Email" />
              </fieldset>
              <fieldset class="form-group">
                <input type="submit" class="btn btn-primary pull-right" value="Submit Review" />
              </fieldset>
            </form>

          </div>
        </section>
      </div>
    </div>
  </body>

</html>
