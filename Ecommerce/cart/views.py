from rest_framework import status
from rest_framework.permissions import IsAuthenticated
from rest_framework.views import APIView
from rest_framework.response import Response
from .serializer import *


class AddCart(APIView):
    permission_classes = [IsAuthenticated]

    def post(self, request, pk, count, price):
        user = request.user
        check = Cart.objects.filter(is_add=True, product_id=pk, user_id=user.id)
        if check:
            try:
                queryset = Cart.objects.update(count=count, price=price * count, is_add=True, product_id=pk,
                                               user_id=user.id)
                self.check_object_permissions(request, queryset)
                data = AddCartSerializer(instance=queryset, data=request.data, partial=True)
                if data.is_valid():
                    data.save()
                    return Response(data.data, status=status.HTTP_200_OK)
                return Response(data.errors, status=status.HTTP_400_BAD_REQUEST)
            except:
                return Response({'update': True, 'price': count * price}, status=status.HTTP_201_CREATED)

        if not check:
            queryset = Cart.objects.create(count=count, price=price * count, is_add=True, product_id=pk,
                                           user_id=user.id)
            self.check_object_permissions(request, queryset)
            data = AddCartSerializer(instance=queryset, data=request.data, partial=True)
            if data.is_valid():
                data.save()
                return Response(data.data, status=status.HTTP_201_CREATED)

        return Response({"available": "product is available"})
