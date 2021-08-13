# controls who sees what.
# added this
from rest_framework import serializers
from api.models import User, Location, Category, Product, Saved, Store, Tier, Review, Order, Security, DropPin, Cart, \
    Options


class ProductSerializer(serializers.ModelSerializer):
    class Meta:
        model = Product
        fields = (
            'prodID', 'categoryID', 'userID', 'prodDescription', 'prodLive', 'prodPicture',
            'prodName', 'prodPrice', 'prodRating', 'prodSaved')


class UserSerializer(serializers.ModelSerializer):
    class Meta:
        model = User
        fields = ('userID', 'locationID', 'userName', 'userEmail', 'userUniversity', 'userPassword')


class LocationSerializer(serializers.ModelSerializer):
    class Meta:
        model = Location
        fields = ('locationID', 'longitude', 'latitude')


class OrderSerializer(serializers.ModelSerializer):
    class Meta:
        model = Order
        fields = ('orderID', 'orderNote', 'quantity', 'prodName', 'orderAmount', 'unitPrice', 'prodID', 'userID')


class CategorySerializer(serializers.ModelSerializer):
    class Meta:
        model = Category
        fields = ('categoryID', 'catName', 'catSumProducts')


class SavedSerializer(serializers.ModelSerializer):
    class Meta:
        model = Saved
        fields = ('savedID', 'prodID', 'userID', 'dateSaved')


class StoreSerializer(serializers.ModelSerializer):
    class Meta:
        model = Store
        fields = ('storeID', 'userID', 'storeName', 'storeDelivery')


class TierSerializer(serializers.ModelSerializer):
    class Meta:
        model = Tier
        fields = ('tierID', 'prodID', 'tierName', 'tierDescription')


class ReviewSerializer(serializers.ModelSerializer):
    class Meta:
        model = Review
        fields = ('reviewID', 'prodID', 'userID', 'reviewStars', 'reviewDescription')


class CartSerializer(serializers.ModelSerializer):
    class Meta:
        model = Cart
        fields = ('cartID', 'userID', 'orderID', 'locationID', 'purchaseTotal', 'orderDate')


class OptionsSerializer(serializers.ModelSerializer):
    class Meta:
        model = Options
        fields = ('optionID', 'tierID', 'optionName', 'optionPrice')
