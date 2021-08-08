# controls who sees what.
# added this
from rest_framework import serializers
from api.models import User, Location, Category, Product, Saved, Store, Tier, Review, Order, Security, DropPin


class ProductCardSerializer(serializers.HyperlinkedModelSerializer):
    class meta:
        model = Product
        fields = ('prodPicture', 'prodName', 'prodPrice', 'prodRating', 'prodRange')


class OrderSerializer(serializers.HyperlinkedModelSerializer):
    class meta:
        model = Order
        fields = ('quantity', 'prodName', 'orderAmount')
