# controls who sees what.
# added this
from rest_framework import serializers
from api.models import User, Location, Category, Product, Saved, Store, Tier, Review, Order, Security, DropPin


class ProductCardSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Product
        fields = ('prodPicture', 'prodName', 'prodPrice', 'prodRating', 'prodRange')


class OrderSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Order
        fields = ('quantity', 'prodName', 'orderAmount', 'unitPrice', 'prodID', 'userID')
