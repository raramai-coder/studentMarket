# controls who sees what.
# added this
from rest_framework import serializers
from api.models import User, Location, Category, Product, Saved, Store, Tier, Review, Order, Security, DropPin


class ProductSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Product
        fields = ('prodID', 'categoryID', 'userID','prodDescription','prodLive','prodDelivery','prodPicture', 'prodName', 'prodPrice', 'prodRating', 'prodRange')


class UserSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = User
        fields = ('userID', 'locationID', 'userName', 'userEmail', 'userUniversity', 'userPassword')


class LocationSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Location
        fields = ('locationID', 'longitude', 'latitude')


class OrderSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Order
        fields = ('orderID', 'orderNote','quantity', 'prodName', 'orderAmount', 'unitPrice', 'prodID', 'userID')


class CategorySerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Category
        fields = ('categoryID', 'catName')


